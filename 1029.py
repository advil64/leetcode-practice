from typing import List
class Solution:
    costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
    # sort by the difference between city B and city A
    sorted_costs = sorted(costs, key=lambda cost: abs(cost[1]-cost[0]), reverse=True)
    city_a = []
    city_b = []
    for c in sorted_costs:
        if c[1] > c[0]:
            if len(city_a) < len(costs)/2:
                city_a.append(c[0])
            else:
                city_b.append(c[1])
        else:
            if len(city_b) < len(costs)/2:
                city_b.append(c[1])
            else:
                city_a.append(c[0])
    print(sum(city_a) + sum(city_b))
