package zn.leave.domain.leetcode.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author ning
 * @date 2020/12/01
 */
public class MinStack {


    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        helper = new Stack();
    }

    public void push(int x) {

        stack.push(x);

        /**
         * >=
         *
         * 811
         * 为了处理相同的最小元素
         *
         */
        if (helper.empty() || helper.peek() >= x) {
            helper.push(x);
        }

    }

    public void pop() {

        Integer s = stack.pop();
        if (Objects.equals(s, helper.peek())) {
            helper.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (!helper.empty()) {
            return helper.peek();
        }
        return 0;
    }
}
