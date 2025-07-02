#include <stdio.h>
#include <stdlib.h>

#define MAX_NODES 100

typedef struct Node {
    int vertex;
    struct Node* next;
} Node;

typedef struct Graph {
    int numVertices;
    Node** adjLists;
    int* visited;
} Graph;

Node* createNode(int v) {
    Node* newNode = malloc(sizeof(Node));
    newNode->vertex = v;
    newNode->next = NULL;
    return newNode;
}

Graph* createGraph(int vertices) {
    Graph* graph = malloc(sizeof(Graph));
    graph->numVertices = vertices;
    graph->adjLists = malloc(vertices * sizeof(Node*));
    graph->visited = malloc(vertices * sizeof(int));
    for (int i = 0; i < vertices; i++) {
        graph->adjLists[i] = NULL;
        graph->visited[i] = 0;
    }
    return graph;
}

void addEdge(Graph* graph, int src, int dest) {
    Node* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;
    newNode = createNode(src);
    newNode->next = graph->adjLists[dest];
    graph->adjLists[dest] = newNode;
}

int DFS(Graph* graph, int start, int goal) {
    graph->visited[start] = 1;
    if (start == goal)
        return 1;
    Node* temp = graph->adjLists[start];
    while (temp) {
        int connectedVertex = temp->vertex;
        if (!graph->visited[connectedVertex]) {
            if (DFS(graph, connectedVertex, goal))
                return 1;
        }
        temp = temp->next;
    }
    return 0;
}

int BFS(Graph* graph, int start, int goal) {
    int queue[MAX_NODES];
    int front = 0, rear = 0;
    graph->visited[start] = 1;
    queue[rear++] = start;
    while (front < rear) {
        int currentVertex = queue[front++];
        if (currentVertex == goal)
            return 1;
        Node* temp = graph->adjLists[currentVertex];
        while (temp) {
            int adjVertex = temp->vertex;
            if (!graph->visited[adjVertex]) {
                graph->visited[adjVertex] = 1;
                queue[rear++] = adjVertex;
            }
            temp = temp->next;
        }
    }
    return 0;
}

void resetVisited(Graph* graph) {
    for (int i = 0; i < graph->numVertices; i++)
        graph->visited[i] = 0;
}

int main() {
    Graph* graph = createGraph(6);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 2, 4);
    addEdge(graph, 3, 5);

    int start = 0, goal = 5;

    resetVisited(graph);
    if (BFS(graph, start, goal))
        printf("Path exists between %d and %d using BFS\n", start, goal);
    else
        printf("No path exists between %d and %d using BFS\n", start, goal);

    resetVisited(graph);
    if (DFS(graph, start, goal))
        printf("Path exists between %d and %d using DFS\n", start, goal);
    else
        printf("No path exists between %d and %d using DFS\n", start, goal);

    return 0;
}
