X, Y, W, S = map(int, input().split())

res = 0
min = min(X, Y)
max = max(X, Y)

if 2 * W >= S:  # 맨해튼이 더 느릴 경우
    # 유클리디안이 더 빠를 경우
    if W >= S:
        res += min * S

        if (max - min) % 2 == 0:
            res += (max - min) * S
        else:
            res += ((max - min) // 2) * S * 2
            res += ((max - min) % 2) * W
    else:
        res += min * S
        res += (max - min) * W
else:  # 맨해튼이 더 빠를 경우
    res += min * 2 * W
    res += (max - min) * W

print(res)