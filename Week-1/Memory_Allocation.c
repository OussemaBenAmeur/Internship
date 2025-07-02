#include <stdio.h>
#include <stdbool.h>
#define MEMORY_SIZE 8
int memory[MEMORY_SIZE];
unsigned char bitmap = 0b00000000;

void print_bitmap() {
    printf("Memory bitmap: ");
    for (int i = 7; i >= 0; i--) {
        printf("%d", (bitmap >> i) & 1);
    }
    printf("\n");
}

bool is_free(int start, int size) {
    for (int i = start; i < start + size; i++) {
        if (i >= MEMORY_SIZE || ((bitmap >> i) & 1)) return false;
    }
    return true;
}
void set_bits(int start, int size, int value) {
    for (int i = start; i < start + size; i++) {
        if (value)
            bitmap |= (1 << i);
        else
            bitmap &= ~(1 << i);
    }
}
int my_malloc(int size) {
    if (size <= 0 || size > MEMORY_SIZE) return -1;

    for (int i = 0; i <= MEMORY_SIZE - size; i++) {
        if (is_free(i, size)) {
            set_bits(i, size, 1);
            return i;
        }
    }

    int free_count = 0;
    for (int i = 0; i < MEMORY_SIZE; i++) {
        if (((bitmap >> i) & 1) == 0)
            free_count++;
    }
    if (free_count >= size) {
        printf("Memory fragmentation\n");
    }

    return -1;
}

void my_free(int index, int size) {
    if (index < 0 || index + size > MEMORY_SIZE) return;
    set_bits(index, size, 0);
}

void my_set(int index, int offset, int value) {
    int pos = index + offset;
    if (pos >= MEMORY_SIZE || ((bitmap >> pos) & 1) == 0) {
        printf("Invalid set %d\n", pos);
        return;
    }
    memory[pos] = value;
}

int my_get(int index, int offset) {
    int pos = index + offset;
    if (pos >= MEMORY_SIZE || ((bitmap >> pos) & 1) == 0) {
        printf("Invalid get %d\n", pos);
        return -1;
    }
    return memory[pos];
}
int main() {
    print_bitmap();
    int ptr = my_malloc(2);
    if (ptr == -1) return 1;
    my_set(ptr, 0, 42);
    printf("Value at allocated block: %d\n", my_get(ptr, 0));
    print_bitmap();
    my_free(ptr, 2);
    print_bitmap();
    return 0;
}
