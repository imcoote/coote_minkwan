T = int(input())
for _ in range(T):
    N = int(input())
    stock = list(map(int, input().split()))
    
    # 주가 리스트 뒤집기
    stock.reverse()
    
    max_price = stock[0]
    total_price = 0

    # 주가를 순회 -> 이익 계산
    for i in range(1, N):
        if max_price < stock[i]:
            max_price = stock[i]  
            continue
        total_price += max_price - stock[i]  # 이익 계산

    print(total_price)