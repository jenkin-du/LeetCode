#include <iostream>

using namespace std;

void getNode(int x, int k);

int main()
{

	int q;
	cin >> q;
	int x, k;
	while (q)
	{
		cin >> x >> k;
		q--;
		getNode(x, k);
	}
	return 0;
}

void getNode(int x, int k)
{

	if (x < 1 || k < 1)
		return;

	int t = 1;
	int n = 1;
	while (n << 1 <= x)
	{
		n = n << 1;
		t++;
	}

	int m = t - k;
	if (m <= 0)
	{
		cout << "-1" << endl;
		return;
	}
	int r = x;
	r = r >> m;
	cout << r << endl;
}