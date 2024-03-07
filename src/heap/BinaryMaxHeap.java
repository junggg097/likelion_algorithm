package heap;

public class BinaryMaxHeap {
    private int[] heap;
    private int size;

    public BinaryMaxHeap() {
        heap = new int[32];
        size = 0;
    }

    public void insert(int item) {
        if (size == heap.length) {
            throw new RuntimeException("Heap is full");
        }

        // 제일 끝에 데이터를 넣어준다.
        heap[size] = item;
        // 해당 데이터를 부모와 비교해가며 힙의 조건을 만족시키게 만든다.
        siftUp(size);
        // 다음에 데이터가 들어갈 위치를 갱신한다.
        size++;
    }

    private void siftUp(int index) {
        // 루트가 아닌 동안
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // 부모보다 자식이 더 작거나 같다
            if (heap[index] <= heap[parentIndex]) {
                break;
            }
            // 부모보다 자식이 더 크다
            // 부모와 자식을 교환한다.
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            // 다음에는 부모 index에서 확인한다.
            index = parentIndex;
        }
    }


    public int remove() {
        if (size == 0 ) {
            throw new RuntimeException("Heap is empty");
        }

        // 돌려줄 데이터 준비
        int root = heap[0];

        // 루트에 제일 끝의 데이터 넣어주기
        heap[0] = heap[size -1];
        size--;

        // 바뀐 root를 자식들과 비교한다.
        siftDown(0);

        return root;
    }

    private void siftDown(int index) {
        while (index < size) {
            // 왼쪽 자식 index
            int leftChild = 2 * index + 1;

            // 오른쪽 자식 index
            int rightChild = 2 * index + 2;

            // 최종적으로 최대값을 비교하기 위한 index
            int largest = index;

            if (
                // 왼쪽 자식이 존재하고,
                leftChild < size &&
                // 왼쪽 자식이 부모보다 크다
                heap[leftChild] > heap[largest]
            ) largest = leftChild;

            if (
                // 오른쪽 자식이 존재하고,
                rightChild < size &&
                // 오른쪽 자식이 왼쪽 + 부모보다 크다
                heap[rightChild] > heap[largest]
            ) largest = rightChild;

            // 제일 큰 노드가 부모였다.
            if (largest == index) {
                break;
            }

            // 제일 큰 자식과 부모를 교체한다.
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            index = largest;
        }
    }

    public static void main(String[] args) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        for (int i = 1; i < 17; i++ ){
            maxHeap.insert(i);
        }
        for (int i = 0; i < 16; i++ ){
            System.out.print(maxHeap.remove() + ", ");

        }
    }
}
