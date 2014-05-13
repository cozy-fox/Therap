-- QUERY: Find Mutual Friends between two friends --
SET @f1=1;
SET @f2=2;

SELECT * FROM (
    SELECT `personal_info`.* FROM 
        (SELECT id1 FROM 
            (SELECT v.id1, v.id2 FROM 
                (SELECT id1, id2 FROM `friendlist` WHERE (id1=@f1 AND id2<>@f2) OR (id2=@f1 AND id1<>@f2) ) AS u, 
                (SELECT id1, id2 FROM `friendlist` WHERE (id1=@f2 AND id2<>@f1) OR (id2=@f2 AND id1<>@f1) ) AS v
            WHERE 
            u.id1 = v.id1 OR
            u.id1 = v.id2 OR
            u.id2 = v.id1 OR
            u.id2 = v.id2 ) AS r 
    WHERE id1!=@f2 ) AS s
    JOIN `personal_info`
    on id1=`personal_info`.account_id
    WHERE id1!=@f2

UNION

SELECT `personal_info`.* FROM 
    (SELECT id2 FROM 
        (SELECT v.id1, v.id2 FROM 
            (SELECT id1, id2 FROM `friendlist` WHERE (id1=@f1 AND id2<>@f2) OR (id2=@f1 AND id1<>@f2) ) AS u, 
            (SELECT id1, id2 FROM `friendlist` WHERE (id1=@f2 AND id2<>@f1) OR (id2=@f2 AND id1<>@f1) ) AS v
        WHERE 
        u.id1 = v.id1 OR
        u.id1 = v.id2 OR
        u.id2 = v.id1 OR
        u.id2 = v.id2 ) AS r 
    WHERE id2!=@f2 ) AS s
    JOIN `personal_info`
    on id2=`personal_info`.account_id
    WHERE id2!=@f2 
) AS m;