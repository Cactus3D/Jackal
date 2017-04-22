#include <iostream>
#include "MyString.h"

using namespace std;
int main(){
    MyString string("Hello");
    cout<<"String length: "<<string.length()<<std::endl;
    cout<<"String length: "<<string.find('E',0)<<std::endl;
    cout<<"String length: "<<string.findLast('L')<<std::endl;
    cout<<"String length: "<<"Substring: "<<std::endl;
    string.substring(0, 3).print();
    string.print();
    cout<<"After removing: "<<std::endl;
    string.remove(1, 2);
    string.print();
    cout<<"After inserting 'abc':"<<std::endl;
    string.insert("abc", 1);
    string.print();
    return 0;
}