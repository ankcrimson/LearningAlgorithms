//
//  main.cpp
//  AlgorithmsPractice
//
//  Created by Srivastava, Ankur on 1/25/16.
//  Copyright © 2016 Srivastava, Ankur (ETW). All rights reserved.
// Implements Floyd’s Cycle-Finding Algorithm

#include <iostream>

struct Node {
    int x;
    Node *next;
};


void populate(Node *begining) {
    Node *myLoopingNode=0;
    for (int i = 0; i<10; i++) {
        begining->x = i*7;
        begining->next = new Node();
        begining=begining->next;
        if(i==6)
            myLoopingNode = begining;
    }
    begining->next = myLoopingNode;
}

bool checkLoop(Node* start) {
    Node *hopper = start;
    while (start!=0 && hopper->next!=0) {
        start=start->next;
        hopper=hopper->next->next;
        if (start==hopper) {
            return true;
        }
    }
    return false;
}

int main(int argc, const char * argv[]) {
    Node *root;
    root = new Node();
    
    populate(root);
    
    std::cout << "Loop : "<<checkLoop(root)<<"\n";
    return 0;
}
