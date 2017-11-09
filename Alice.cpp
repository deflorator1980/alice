//#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <streambuf>
#include <string>
#include <cerrno>
#include <iterator>
#include <sstream>
#include <vector>
#include <chrono>
#include <algorithm>


using namespace std;
using namespace std::chrono;

int main() {
    std::ifstream in("Alice.txt", std::ios::in | std::ios::binary);
//    std::ifstream in("rnd.txt", std::ios::in | std::ios::binary);

    string s =
            std::string(
                    std::istreambuf_iterator<char>(in),
                    std::istreambuf_iterator<char>()
            );

    istringstream iss(s);


    vector<string> words{istream_iterator<string>{iss},
                         istream_iterator<string>{}};


//cout << s.length() << endl;
//

//imperative
    steady_clock::time_point start0 = steady_clock::now();
    int count0 = 0;
    for (auto &w : words) {
        if (w.size() > 12) {
            ++count0;
//cout << w << endl;
        }
    }
    steady_clock::time_point stop0 = steady_clock::now();

    cout << count0 << endl;
    cout << "Time diff = " << duration_cast<nanoseconds>(stop0 - start0).count() << endl;
// }


// functional
   steady_clock::time_point start1 = steady_clock::now();
   int count1 = count_if(words.begin(), words.end(), [](auto& w) {return w.size() > 12;});
   steady_clock::time_point stop1 = steady_clock::now();

   cout << count1 << endl;
   cout << "Time diff = " << duration_cast<nanoseconds> (stop1 - start1).count() << endl;


   return 0;
}
