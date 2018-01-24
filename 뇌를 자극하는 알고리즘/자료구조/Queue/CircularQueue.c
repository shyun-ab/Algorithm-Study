#include "CircularQueue.h"

void CreateQueue(CircularQueue** Queue, int Capacity) {
	(*Queue) = (CircularQueue*)malloc(sizeof(CircularQueue));
	(*Queue)->Nodes = (Node*)malloc(sizeof(Node) * (Capacity + 1));
	(*Queue)->Capacity = Capacity;
	(*Queue)->Front = 0;
	(*Queue)->Rear = 0;
}

void DestroyQueue(CircularQueue* Queue) {
	free(Queue->Nodes);
	free(Queue);
}

void Enqueue(CircularQueue* Queue, ElementType Data) {
	int Position = 0;

	if (Queue->Rear == Queue->Capacity) {
		Position = Queue->Rear;
		Queue->Rear = 0;
	}
	else {
		Position = Queue->Rear++;
	}

	Queue->Nodes[Position].Data = Data;
}

ElementType Dequeue(CircularQueue* Queue) {
	int Position = Queue->Front;

	if (Queue->Front == Queue->Capacity)
		Queue->Front = 0;
	else
		Queue->Front++;

	return Queue->Nodes[Position].Data;
}

int GetSize(CircularQueue* Queue) {
	if (Queue->Front <= Queue->Rear)
		return Queue->Rear - Queue->Front;
	else
		return Queue->Rear + (Queue->Capacity - Queue->Front) + 1;
}

int IsEmpty(CircularQueue* Queue) {
	return (Queue->Front == Queue->Rear);
}
int IsFull(CircularQueue* Queue) {
	if (Queue->Front < Queue->Rear)
		return (Queue->Rear - Queue->Front) == Queue->Capacity;
	else
		return (Queue->Rear + 1) == Queue->Front;
}