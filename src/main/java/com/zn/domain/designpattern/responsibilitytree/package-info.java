package com.zn.domain.designpattern.responsibilitytree;


//责任树模式，将责任链与策略模式融合



/*

https://mp.weixin.qq.com/s/Wib0Ly45te00HMUnIG-tbg

责任链模式是实现了类似“流水线”结构的逐级处理，通常是一条链式结构，将“抽象处理者”的不同实现串联起来：如果当前节点能够处理任务则直接处理掉，如果无法处理则委托给责任链的下一个节点，如此往复直到有节点可以处理这个任务。



 */