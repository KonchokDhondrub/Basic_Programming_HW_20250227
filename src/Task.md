### 1
Дана Map<String:String> - получить список строк вида “параметр:значение”  
Например:  
```
Map:{  
“jack”,”qwer13”  
“john”,”zxc45”  
}
```
Список :  
```
“jack:qwer13”, “john:zxc45”  
```

### 2 Обратная задача:   
Дан список строк вида “параметр:значение” (например, “length:8”, “name:Jack”  и т.д).   
Получить  map, где параметр – это ключ, его значение – значение.  
При этом, если в списке дважды встретился один и тот же параметр,  
то значения должны быть указаны через запятую 

### 3. По желанию
   Исходные данные второй задачи, но нужно получить Map<String, List<String>>  
   где ключ - ключ, значение - список значений для этого ключа.
