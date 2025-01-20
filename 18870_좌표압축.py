import sys

N = int(input())
X_list = list(map(int, sys.stdin.readline().rstrip().split()))

X_set = set(X_list)
a = list(X_set)
a.sort()

X_dict = {}
for i in range(len(a)):
    X_dict[a[i]] = i

for i in X_list:
    print(X_dict[i], end=' ')