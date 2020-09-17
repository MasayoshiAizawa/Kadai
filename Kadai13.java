package practice009;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Kadai13 {
	public static void main (String args[]){

		List<CompletableFuture<String>> list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			String proc = ("処理対象" + (i +1));
			System.out.println(proc + "実行済み");
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub1(proc).process()));
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub2(proc).process()));
				list.add(CompletableFuture.supplyAsync(() -> new ParallelProcessSub3(proc).process()));
		}

	CompletableFuture.allOf(
		list.toArray(new CompletableFuture[list.size()]))
		.whenComplete((result,ex) -> {
			if(ex == null){
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
	}
}
