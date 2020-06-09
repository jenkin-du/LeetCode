#include<iostream>

using namespace std;

typedef struct Node
{
	int value;
	struct Node *next;
}Node;
int main() {

	int n, k;
	cin >> n >> k;
	Node* head = new Node();
	
	bool first = true;
	while (n) {
		n--;
		int a;
		cin >> a;
		int* arr = new int[a];
		int m = a;
		int t = 0;
		while (t<a) {
			cin >> arr[t];
			t++;
		}

		Node* p = head;
		if (first) {
			while (m) {
				Node* node = new Node();
				node->value = arr[m - 1];
				node->next = NULL;
				
				p->next = node;
				p = p->next;

				m--;
			}
			first = false;
		}
		while (m) {
			
			Node* node = new Node();
			node->value = arr[m - 1];
			node->next = NULL;
			
			while (p ->next != NULL&&p->next->value > arr[m -1]) {
				p = p->next;
			}
			if (p->next == NULL&&p->value > arr[m - 1]) {
				p->next = node;
			}
			else {
				node->next = p->next;
				p->next = node;
			}

			p = node;
			m--;
		}
	}

	Node* q = head->next;
	while (k) {
		cout << q->value << " ";
		k--;
		q = q->next;
	}

	return 0;
}