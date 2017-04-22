#include <iostream>
#include <stdlib.h>
#include <string.h>

class MyString {
    private:
        char* temp;
        int len;
        
    public:
        MyString(char *_str);
        ~MyString();

        int length();
        int lengthOf(char *target);
        int find(char ch, int start);
        int findLast(char ch);
        MyString substring(int index, int count);
        void remove(int index, int count);
        void insert(char *s, int index);
        void print();
}