package ru.tinkoff.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacansiesResponseModel {
    private Response response;

    @Data
    public static class Response {
        private Category category;
        private SpecialtyInfo specialtyInfo;
        private List<String> cities;
        private String city;
        private String experience;
        private String externalId;
        private String id;
        private Boolean isResumeRequired;
        private String offer;
        private String requirements;
        private String responsibilities;
        private String shortDescription;
        private String specialty;
        private String status;
        private String tasks;
        private String title;
        private String urlSlug;

        @Data
        public static class SpecialtyInfo {
            private String createdAt;
            private String deletedAt;
            private String id;
            private String name;
            private int order;
            private String urlSlug;
        }

        @Data
        @SuppressWarnings("unused")
        public static class Category {
            private String createdAt;
            private String deletedAt;
            private String id;
            private String name;
            private int order;
            private String urlSlug;
        }
    }

}

/*
{
    "response": {
        "id": "25533034-03fb-43c7-81bf-1b34192d721b",
        "status": "published",
        "title": "Инженер по тестированию (backend)",
        "specialty": "Тестирование",
        "specialtyInfo": {
            "createdAt": "2018-03-27T09:03:49.214Z",
            "deletedAt": null,
            "id": "a8a27761-b243-45a3-a537-e94c0e9693c6",
            "name": "Тестирование",
            "order": 26,
            "urlSlug": "testirovanie"
        },
        "city": "Любой город",
        "experience": "Middle",
        "tasks": "<p>Тинькофф — компания нового поколения: без отделений и очередей, мы постоянно развиваемся и добавляем новые продукты и услуги.</p><p><br>Мы в поиске QA-backend инженеров, которые станут частью экспертного сообщества и смогут поддержать наши ценности в вопросах качества и безопасности продуктов. Среди проектов есть направления внешних и внутренних платформ для обеспечения жизни наших процессов и бизнес-инструментов.</p>",
        "requirements": "<ul><li>Имеешь опыт тестирования backend (API (SOAP/REST), базы данных) от 2 лет</li><li>Знаешь один из языков программирования (Java, Kotlin, Python, C#, C++, Scala, Go)</li><li>Понимаешь техники тест-дизайна, имеешь опыт разработки тестовой документации, анализируешь спецификации</li><li>Понимаешь основы процесса автоматизации, подходы к автоматизации (BDD, TDD, и т.д.)</li><li>Работаешь с SQL (знаешь типы данных и их преобразование, умеешь составлять запросы с вложенными запросами, используешь JOIN)</li><li>Работаешь с системами логирования, читаешь логи (отчеты, алерты, дашборды); работаешь с файловой системой и папками с помощью консольных команд</li></ul>",
        "responsibilities": "<ul><li>Проводить функциональное и автоматизированное тестирование (в том числе анализировать и тестировать требования)</li><li>Работать в продуктовой команде в рамках Agile процессов (в том числе работать с ошибками)</li><li>Разрабатывать тестовую документацию для проекта (в том числе разрабатывать приемочные критерии), готовить тестовые данные</li><li>Сопровождать релизы</li></ul>",
        "offer": "<ul>\n  <li>Возможность работы в аккредитованной ИТ компании</li>\n  <li>Работу в офисе или удаленно — по договоренности</li>\n  <li>Профессиональное развитие. Вы получите доступ к библиотеке с технической литературой, тренингами и мастер-классами для сотрудников</li>\n  <li>Заботу о здоровье. Оформим полис ДМС со стоматологией и страховку от несчастных случаев. Предложим льготное страхование вашим близким</li>\n  <li>Компенсацию такси, парковки и 50% затрат на спорт от стоимости абонемента</li>\n  <li>Компенсацию обедов. А если захотите перекусить, на каждом этаже есть кухня с чаем, кофе и фруктами</li>\n  <li>Достойную зарплату — обсудим ее на собеседовании</li>\n</ul>",
        "urlSlug": "qa-backend",
        "externalId": "61825518-fa28-459e-8041-d8fb1d62d593",
        "category": {
            "createdAt": "2018-03-22T13:30:28.179Z",
            "deletedAt": null,
            "id": "5ea37b04-16b9-42a3-a3a9-87816e84e381",
            "name": "Работа в IT",
            "order": 3,
            "urlSlug": "it"
        },
        "cities": [
            "Любой город"
        ],
        "isResumeRequired": true,
        "shortDescription": null
    }
}
 */
