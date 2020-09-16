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
			stringlist.add("�����Ώ�" + (i +1));
		}
		
		//�������s���鏈�������X�g��
		var list = List.of(
			for(String proc : stringlist){
				ParallelProcessSub1 par1 = new ParallelProcessSub1(proc);
				ParallelProcessSub2 par2 = new ParallelProcessSub2(proc);
				ParallelProcessSub3 par3 = new ParallelProcessSub3(proc);
				CompletableFuture.supplyAsync(() -> par1.process());
				CompletableFuture.supplyAsync(() -> par2.process());
				CompletableFuture.supplyAsync(() -> par3.process());
				CompletableFuture.supplyAsync(() -> System.out.println(proc + "���s�ς�"));
			}
		);
		
		//�����̏��������s
		CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()]))
			//���ׂĊ�����
			.whenComplete((result,ex) -> {
				if(ex == null){
					//���Ɍ��ʂ��o��
					list.forEach((future) -> {
						System.out.println(future.get());
					});
				}else{
					System.out.println(ex.getMessage());
				}
			});
	}
}