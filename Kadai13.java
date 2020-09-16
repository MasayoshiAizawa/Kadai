package practice009;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

public class Kadai13 {
	public static void main (String args[]){
		
		List<String> stringlist = new ArrayList<>();
		
		for(int i = 0; i < 5; i++){
			stringlist.add("処理対象" + (i +1));
		}
		
		//同時実行する処理をリスト化
		for(String proc : stringlist){
			var list = List.of(
				CompletableFuture.supplyAsync(() -> new ParallelProcessSub1(proc).process()),
				CompletableFuture.supplyAsync(() -> new ParallelProcessSub2(proc).process()),
				CompletableFuture.supplyAsync(() -> new ParallelProcessSub3(proc).process()),
				CompletableFuture.supplyAsync(() -> System.out.println(proc + "実行済み"))
			);
		}
		
		//複数の処理を実行
		CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()]))
			//すべて完了後
			.whenComplete((result,ex) -> {
				if(ex == null){
					//順に結果を出力
					list.forEach((future) -> {
						System.out.println(future.get());
					});
				}else{
					System.out.println(ex.getMessage());
				}
			});
	}
}
