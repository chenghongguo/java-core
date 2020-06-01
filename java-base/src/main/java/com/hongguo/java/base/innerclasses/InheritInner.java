package com.hongguo.java.base.innerclasses;

/**
 * InheritInner
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class InheritInner extends WithInner.Inner {

   public InheritInner(WithInner withInner) {
       withInner.super();
   }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}


