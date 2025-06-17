select A.rest_id, A.rest_name, A.food_type, A.favorites, A.address, round(avg(review_score),2) as score
from rest_info A join rest_review B on A.rest_id = B.rest_id
where A.address like '서울%'
group by A.rest_id, A.rest_name, A.food_type, A.favorites, A.address
order by 6 desc, 4 desc