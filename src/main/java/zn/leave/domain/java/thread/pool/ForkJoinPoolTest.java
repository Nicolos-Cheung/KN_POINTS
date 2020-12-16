package zn.leave.domain.java.thread.pool;

/**
 *
 * 将大任务拆成小任务，将小任务并行计算，合并结果
 *
 * 工作窃取模式：多个双端队列，当某个队列为空，会随机选一个队列将任务从队列末尾取出，执行（窃取）
 *
 * @author ning
 * @date 2020/11/30
 */
public class ForkJoinPoolTest {


    public static void main(String[] args) {

    }


}
