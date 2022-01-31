-- № 1
with stat as (select f.film_id, f.description, f.duration, t.start_time, t.end_time
              from shedule s
                       join films f on s.film_id = f.film_id
                       join show_time t on t.id = s.show_id
              where s.end_date > sysdate) /* берем актуальное расписание*/
select f.film_id, t.start_time, f.duration, stat.film_id, stat.start_time, stat.duration
from shedule s
         join films f on s.film_id = f.film_id
         join show_time t on t.id = s.show_id
where s.film_id = stat.film_id
  and s.end_date > sysdate
  and t.start_time between stat.start_time and stat.end_time
order by 2 asc;

-- № 2
with stat as (select f.film_id, f.description, f.duration, t.start_time, t.end_time
              from shedule s
                       join films f on s.film_id = f.film_id
                       join show_time t on t.id = s.show_id
              where s.end_date > sysdate) /* берем актуальное расписание*/
select f.film_id, t.start_time, f.duration, stat.film_id, stat.start_time, t.start_time - stat.end_time as duration
from shedule s
         join films f on s.film_id = f.film_id
         join show_time t on t.id = s.show_id
where s.end_date > sysdate
  and t.start_time + interval '30' minute <= stat.end_time
order by 6 asc;

-- № 3
select f.description,
       count(t.id)           as all_visitors,
       avg(count(t.id))      as avg_visitors,
       sum(tt.tickect_price) as ammount
from films f
         left join tickets t on f.film_id = t.film_id
         left join ticket_types tt on t.tcktp_id = tt.tcktp_id
group by f.description
