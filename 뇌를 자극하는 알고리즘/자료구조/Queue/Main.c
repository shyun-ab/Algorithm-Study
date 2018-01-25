#include "CircularQueue.h"

int main(void) {
	int i;
	CircularQueue* Queue;

	CreateQueue(&Queue, 10);

	Enqueue(Queue, 1);
	Enqueue(Queue, 2);
	Enqueue(Queue, 3);
	Enqueue(Queue, 4);

	for (i = 0; i < 3; i++) {
		printf("Dequeue: %d, ", Dequeue(Queue));
		printf("Front: %d, Rear: %d\n", Queue->Front, Queue->Rear);
	}

	i = 100;
	while (IsFull(Queue) == 0) {
		Enqueue(Queue, i++);
	}

	printf("Capacity: %d, Size: %d\n\n", Queue->Capacity, GetSize(Queue));

	while (IsEmpty(Queue) == 0) {
		printf("Dequeue: %d, ", Dequeue(Queue));
		printf("Front: %d, Rear: %d\n", Queue->Front, Queue->Rear);
	}

	DestroyQueue(Queue);

	return 0;
}