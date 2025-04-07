import sys

S, E, Q = map(str, sys.stdin.readline().split())
before_dic = {} # 개총 시작전에 참여한 사람들
people = {} # 개총 시작전에 들어온 사람들 중 개총 종료시간과 스트리밍 종료시간 사이에 들어온 사람

for i in sys.stdin:
    time, nickname = i.rstrip().split() # 시간과 닉네임을 한줄씩 받아옴

    if time <= S:
        before_dic[nickname] = time
    # 개총 종료시간과 스트리밍 종료시간 사이에 들어온 사람을 확인
    elif E <= time <= Q:
        if nickname in before_dic:
            people[nickname] = 1

print(len(people))