import sys

N = int(sys.stdin.readline())
stack = []
start = 1
oper_arr = []
idx = 0  # 수열의 인덱스

while idx < N:
    end = int(sys.stdin.readline())
    
    while start <= end:  
        stack.append(start)
        oper_arr.append('+')
        start += 1
    
    if stack and stack[-1] == end:  # 마지막 항이 end와 같을 경우
        stack.pop()  
        oper_arr.append('-')
        idx += 1  
    else:  
        print("NO")
        break
else:
    for i in oper_arr:
        print(i)
