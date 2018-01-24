#ifndef CIRCULAR_QUEUE_H
#define CIRCULAR_QUEUE_H

#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct tagNode {
	ElementType Data;
} Node;

typedef struct tagCircularQueue {
	int Capacity;
	int Front;
	int Rear;

	Node* Nodes;
} CircularQueue;

void CreateQueue(CircularQueue** Queue, int Capacity);
void DestroyQueue(CircularQueue* Queue);
void Enqueue(CircularQueue* Queue, ElementType Data);
ElementType Dequeue(CircularQueue* Queue);
int GetSize(CircularQueue* Queue);
int IsEmpty(CircularQueue* Queue);
int IsFull(CircularQueue* Queue);

#endif