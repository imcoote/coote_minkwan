N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

tmp = 0
for i in range(N):
    tmp += A[i] * B[i]

print(tmp)