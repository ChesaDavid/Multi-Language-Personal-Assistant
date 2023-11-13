#include <iostream>
#include <vector>
using namespace std;

int main() {
    std::vector<int> informatii; // Declarați un vector pentru a stoca informații întregi

    // Adăugați informații în vector
    informatii.push_back(42);
    informatii.push_back(123);
    informatii.push_back(7);

    // Accesați și afișați informațiile din vector
    :cout << "Informații stocate: ";
    for (const int& item : informatii) {
        std::cout << item << " ";
    }
    cout << std::endl;

    return 0;
}