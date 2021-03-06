#include "MyString.h"

MyString::MyString(char *value) {
    int length = lengthOf(value);
    temp = new char[length];
    strncpy(temp, value, length);
    temp[length] = '\0';
    len = length;
}

MyString::MyString(const MyString &str) : temp(str.temp), len(str.len) {}

MyString::~MyString() {
    delete temp;
}

int MyString::length() {
    return len;
}

MyString MyString::copy(const MyString &str) {
    return MyString(str);
}

int MyString::find(char ch, int start) {
    char* target = temp;
    for(int i = start; i < len; i++) {
        if(target[i] == ch)
            return i;
    }
    return -1;
}

int MyString::findLast(char ch) {
    char* target = temp;
    int result = -1;
    for(int i = len - 1; i >= 0; i--) {
        if(target[i] == ch) {
            return i;
        }
    }
    return result;
}

MyString MyString::substring(int index, int count) {
    char* target = temp;
    if(count > lengthOf(target) - index)
        return NULL;
    char *array = new char[count + 1];
    for (int i = index; i < count; i++) {
        array[i - index] = target[i];
    }
    array[count] = '\0';
    return MyString(array);
}

void MyString::remove(int index, int count) {
    if(count > length() - index)
        count = length() - index;
    int targetLength = length() - count;
    char* t = new char[targetLength + 1];
    int j = 0;
    for (int i = 0; i < length(); i++) {
        if(i >= index && i<index+count)
            continue;
        t[j++] = temp[i];
    }
    t[targetLength] = '\0';
    delete temp;
    temp = t;
}

void MyString::insert(char *s, int index) {
    int lens = lengthOf(s) + len;
    char* result = new char[lens];
    strncpy(result, temp, index);
    result[index] = '\0';
    strcat(result, s);
    strcat(result, temp + index);
    delete temp;
    temp = result;
    len = lens;
}

void MyString::print() {
    std::cout<<"String value: "<<temp<<std::endl;
}

int MyString::lengthOf(char *target) {
    int count = 0;
    while(*target != '\0') {
        count++;
        *target++;
    }
    return count + 1;
}