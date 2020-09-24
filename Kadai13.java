package practice009;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Kadai13 {
	public static void main (String args[]){

		long startTime = System.currentTimeMillis();

		//同時実行する処理のリスト化
		List<Future<String>> list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			String proc = ("処理対象" + (i +1));
			System.out.println(proc + "実行済み");
				CompletableFuture.supplyAsync(() -> {
					ParallelProcessSub1 sub1 = new ParallelProcessSub1(proc);
					return sub1.process();
				})
					.thenAcceptAsync((result) -> {
						list.add(result);
					});
				CompletableFuture.supplyAsync(() -> {
					ParallelProcessSub2 sub2 = new ParallelProcessSub2(proc);
					return sub2.process();
				})
					.thenAcceptAsync((result) -> {
						list.add(result);
					});
				CompletableFuture.supplyAsync(() -> {
					ParallelProcessSub3 sub3 = new ParallelProcessSub3(proc);
					return sub3.process();
				})
					.thenAcceptAsync((result) -> {
						list.add(result);
					});
		}

		for(Future<String> se : list){
				System.out.println(se.get());
		};

		long endTime = System.currentTimeMillis();
		System.out.println("実行時間" + (endTime -startTime));
	}
}
