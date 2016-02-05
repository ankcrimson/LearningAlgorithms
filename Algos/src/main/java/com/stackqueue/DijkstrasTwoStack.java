package com.stackqueue;

public class DijkstrasTwoStack {

  StackArray<Integer> nums;
  StackArray<Character> oprations;
  
  public DijkstrasTwoStack() {
    nums = new StackArray<>();
    oprations = new StackArray<>();
  }
  
  public int perform(int i, char ch, int j) {
    switch(ch) {
      case '+': return i+j;
      case '-': return j-i;
      default: break;
    }
    return 0;
  }
  
  public int parseAndPopulate(char[] chars) {
    int ans=0;
    int num=0;
    boolean numCont=false;
    for(char ch:chars) {
      if(ch>='0'&&ch<='9') {
        num*=10;
        num+=ch-'0';
        numCont=true;
      } else {
        if(numCont) {
          nums.push(num);
          num=0;
          numCont=false;
        }
        switch(ch) {
          case ')' : nums.push(perform(nums.pop(),oprations.pop(),nums.pop())) ;break;
          case '(' : break;
          default: oprations.push(ch);
        }
      }
    }
    return nums.pop();
  }
  
  public int evaluate(String eqn) {
    int res=0;
    char[] chars = eqn.toCharArray();
    return parseAndPopulate(chars);
    
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    DijkstrasTwoStack dijkstrasTwoStack = new DijkstrasTwoStack();
    System.out.println(dijkstrasTwoStack.evaluate("(1+(2-4))"));
    System.out.println(dijkstrasTwoStack.evaluate("(5+((7-(3+(2+((4-6)-9))))-4))"));
  }

}
