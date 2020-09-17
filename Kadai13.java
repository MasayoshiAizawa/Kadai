package practice009;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Kadai13 {
	public static void main (String args[]){

		long startTime = System.currentTimeMillis();

		//同時実行する処理のリスト化
		List<CompletableFuture<String>> list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			String proc = ("処理対象" + (i +1));
			System.out.println(proc + "実行済み");
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub1(proc).process()));
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub2(proc).process()));
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub3(proc).process()));
		}

		//複数の処理の実行
		CompletableFuture.allOf(
				list.toArray(new CompletableFuture[list.size()]))
			.whenComplete((result,ex) -> {
				if(ex == null){
					//順に結果を表示
					list.forEach((future) -> {
						try {
							System.out.println(future.get());
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
						}
					});
			}else{
				System.out.println("err=" + ex);
			}
		});
		long endTime = System.currentTimeMillis();
		System.out.println("実行時間" + (endTime -startTime));
	}
}
