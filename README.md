## Учебный проект по автоматизации тестирования (API)
### Веб сайт <a target="_blank" href="https://www.tinkoff.ru/career/it/about/">Работа в Тинькофф</a>

<p align="center">
<img title="Работа в Тинькофф" src="images/screens/api-tinkoff-page.png">
</p>

## :maple_leaf: Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins)
- Allure-отчет
- Интеграция с Allure TestOps
- Уведомление в Telegram о результатах прогона тестов

## :maple_leaf:Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://rest-assured.io/"><img src="images/logo/Rest-Assured.png" width="50" height="50"  alt="Rest-assured"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :maple_leaf: Список проверок, реализованных в автотестах

- [x] Проверка получения вакансии по названию
- [x] Проверка отклика на вакансию
- [x] Проверка получения списка вакансий по спец-сти / по грэйду


## :maple_leaf: Запуск тестов

###  Локальный запуск :
Пример командной строки:
```bash
gradle clean test
```
Получение отчёта:
```bash
gradle allureServe
```
###  Удаленный запуск (в Jenkins):
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-NazilyaMullagildina_API-tests/">проект</a>

![This is an image](/images/screens/api-Jenkins-main.png)

2. Выбрать пункт **Собрать с параметрами**
3. Нажать **Собрать**
4. Результат запуска сборки можно посмотреть в отчёте Allure

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-NazilyaMullagildina_API-tests/3/allure/">Allure report</a>

###  Главное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/api-allureRep_dashboard.png">
</p>

###  Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/api-allureRep_TK.png">
</p>

###  Графики

<p align="center">
<img title="Allure Graphics" src="images/screens/api-allureRep-Graphs.png">
</p>

## <img src="images/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/1865/dashboards/2126">Allure TestOps</a>
### Cписок всех тест кейсов
<p align="center">
<img title="Allure Graphics" src="images/screens/api-allureTO_Suites.png">
</p>


### Dashboard с результатами тестирования
<p align="center">
<img title="Allure Graphics" src="images/screens/api-allureTO_dashboard.png">
</p>

### Пример отчёта выполнения одного из автотестов
<p align="center">
<img title="Allure Graphics" src="images/screens/api-allureTO_TK.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram о результатах прогона тестов

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/api-telegramNotif.png" >
</p>
