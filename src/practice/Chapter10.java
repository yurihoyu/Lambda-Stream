package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 以下記述
		long count = list.stream().filter(f -> f.isDone() != true).count();
		System.out.println("未完了のタスクの個数は" + count);
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");


		// Stream APIとラムダ式を使って記述
		list.stream()// Streamを生成
				.filter(f -> f.isDone() != true) //済んでないタスク抽出
				.sorted((f1, f2) -> f1.getDate().compareTo(f2.getDate())) // 日付が若い順に並び替える
				// 終端操作: 標準出力

				.forEach(System.out::println);

		//新しいリスト
		//		List<Task> Incomplete = new ArrayList<Task>();

		// 拡張for文でtasksをループ
		//		for (Task task : list) {
		//			if (!task.isDone()) {
		//				Incomplete.add(task);
		//			}
		//		}

		// 日付が若い順に並べ替える
		//		Incomplete.sort(new Comparator<Task>() {
		//
		//			  public int compare(Task a, Task b) {
		//		             return a.getDate().compareTo(b.getDate());
		//		         }
		//
		//		});

		//
		//		Incomplete.forEach(t -> {
		//            System.out.println(t);
		//
		//        });

	}
}
