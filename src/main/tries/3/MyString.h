#ifndef LAB1_1_STRING_H
#define LAB1_1_STRING_H

#include <iostream>
#include <stdlib.h>
#include <string.h>

class MyString {
    char* temp;
    int len;
    public:
        MyString(char *value);
        MyString(const MyString &str);
        ~MyString();

        MyString copy(MyString str);
        int length();
        int find(char ch, int start);
        int findLast(char ch);
        MyString substring(int index, int count);
        void remove(int index, int count);
        void insert(char *s, int index);
        void print();
    private:
        int lengthOf(char *target);
}

#endif //LAB1_1_STRING_H