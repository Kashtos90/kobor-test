# Автоматизации тестирования :video_game: Plarium :video_game:
## Проект разработан для [Plarium.com](https://plarium.com/ru/)
## :bookmark_tabs: Содержание
- [Технологический стек](https://github.com/Kashtos90/plarium_web/blob/main/README.md#hammer_and_wrench-%D1%82%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9-%D1%81%D1%82%D0%B5%D0%BA)
- [Реализованные тесты](https://github.com/Kashtos90/plarium_web/edit/main/README.md#heavy_check_mark-%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5-%D1%82%D0%B5%D1%81%D1%82%D1%8B)
- [Сборка в Jenkins](https://github.com/Kashtos90/plarium_web/edit/main/README.md#robot-%D1%81%D0%B1%D0%BE%D1%80%D0%BA%D0%B0-%D0%B2-jenkins)
- [Запуск из терминала](https://github.com/Kashtos90/plarium_web/edit/main/README.md#computer-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-%D0%B8%D0%B7-%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D0%BB%D0%B0)
- [Отчет Allure](https://github.com/Kashtos90/plarium_web/edit/main/README.md#bar_chart-%D0%BE%D1%82%D1%87%D0%B5%D1%82-allure)
- [Интеграция с Allure TestOps](https://github.com/Kashtos90/plarium_web/edit/main/README.md#chart_with_upwards_trend-%D0%B8%D0%BD%D1%82%D0%B5%D0%B3%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D1%81-allure-testops)
- [Отчет в Telegram](https://github.com/Kashtos90/plarium_web/edit/main/README.md#calling-%D0%BE%D1%82%D1%87%D0%B5%D1%82-%D0%B2-telegram)
- [Видео-пример теста](https://github.com/Kashtos90/plarium_web/edit/main/README.md#film_strip-%D0%B2%D0%B8%D0%B4%D0%B5%D0%BE-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D0%BF%D1%80%D0%BE%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F-%D1%82%D0%B5%D1%81%D1%82%D0%B0)
## :hammer_and_wrench: Технологический стек
> Для разработки проекта использовался следующий инструментарий:
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Telegram" src="images/logo/Allure_TO.svg">
</p>

## :heavy_check_mark: Реализованные тесты
> В проекте были реализованы:
- Проверка ошибочной авторизации
- Проверка успешной авторизации
- Проверка отображения блога
- Проверка англ. языка
- Проверка списка жанров
## :robot: Сборка в Jenkins
Протестировать код, а также задать необходимые параметры, можно в [Jenkins](https://jenkins.autotests.cloud/job/plarium_test/)

![Jenkins](https://user-images.githubusercontent.com/99273725/164048039-45030e8e-d45e-4c4d-9e2c-40f4be6e5f31.png)

### Настраиваемые параметры
- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 100.0)
- size (размер окна браузера, по умолчанию 1920x1080)
- remoteUrl (адрес удаленного сервера selenoid)
- threads (количество потоков)
## :computer: Запуск из терминала
Тесты можно запустить как локально:
```
gradle clean test
```

Так и удаленно через Selenoid:
```
clean
test
-Dbrowser=${BROWSER}
-DremoteBrowser=${REMOTE_BROWSER}
-Dversion=${VERSION}
-Dsize=${BROWSER_SIZE}
-Dthreads=${THREADS}
```

## :bar_chart: Отчёт Allure
> В отчёте можно получить общую информацию по тестам

![allure rep1](https://user-images.githubusercontent.com/99273725/164039431-0f06abfe-19ff-4f66-84c2-dffec58081d3.png)

> А также подробную информацию по каждому отдельно

![allure rep2](https://user-images.githubusercontent.com/99273725/164040313-65722273-f4d3-449f-a8db-88297a4e24f0.png)
## :chart_with_upwards_trend: Интеграция с Allure TestOps
> Ещё одним инструментом для визуализации и анализа использован отчёт в Allure TestOps

![allure to1](https://user-images.githubusercontent.com/99273725/164053210-a28c98fc-4768-449a-a2ba-e0f58ed26922.png)

![allure to2](https://user-images.githubusercontent.com/99273725/164054023-88624672-d081-4ee1-84bc-ff536a83e63c.png)

## :calling: Отчёт в Telegram
> После завершения тестов в Telegram приходит уведомление с результатами

![telegram](https://user-images.githubusercontent.com/99273725/164043535-6ddc1b4f-2313-4970-a14a-3334ebe02cc5.png)

## :film_strip: Видео-пример теста
> Также, к каждому тесту прилагается видео с поэтапным прохождением

![selenoid](https://user-images.githubusercontent.com/99273725/164035550-05fef5f8-50e3-41c0-aa9c-894646776e7e.gif)
