package com.behinesprutrol.envo.match.data

object Constants {
    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"Именно этот шахматный термин, который придумал в 1561 году испанский монах Рюи Лопес де Сегура, происходит от итальянского выражения «выставлять вперед ногу», то есть ставить подножку.",
            "Гамбит","Кульбит",
            "Магнит","Гранит",1
        )
        questionList.add(que1)

        val que2 = Question(
            2,"Этот ирландский велосипедист завоевал зеленую майку на Тур де Франс четыре раза, в 1982, 1983, 1985 и 1989 годах. Его рекорд был побит только в 2000 Эриком Цабелем из Германии.",
        "Бен Алекс","Тим Миллер",
            "Шон Келли ","Морган Грот",3
        )
        questionList.add(que2)

        val que3 = Question(
            3,"Этот венгерский боксер выиграл три олимпиады подряд – в 1948, 1952 и 1956 годах.",
        "Ласло Папп","Бинго Лам",
            "Фиша Джаб","Боб Фет",1
        )
        questionList.add(que3)

        val que4 = Question(
            4,"Этот французский пловец удивил мир в этом году, дважды побив мировой рекорд на 100 м вольным стилем на чемпионате Европы этого года. Теперь мировой рекорд равен 47.50 с.",
        "Люк Стих","Алан Бернар",
            "Никки Кук","Лани Крав",2
        )
        questionList.add(que4)

        val que5 = Question(
            5,"Город Скьен, место рождения Генрик Ибсена, расположен на юге Норвегии, в регионе, давшем свое имя типу лыж, к которым ботинок крепится только на носке. Как называются такие лыжи?",
            "Винмарк","Промомарк",
            "Скаймарк","Телемарк",4
        )
        questionList.add(que5)

        val que6 = Question(
            6,"Чарреада –национальный мексиканский вид спорта, который состоит из девяти дисциплин у мужчин, включая 'El Paso de la Muerte' (шаг смерти), и одной у женщин, 'Escaramuza' (стычка). Что это за спорт?",
            "Велоспорт","Водное поло",
            "Автогонки","Родео",4
        )
        questionList.add(que6)

        val que7 = Question(
            7,"Эта видео игра Nintendo 1981 года была первой, в которой появился итальянский сантехник Марио. В этой игре Марио спасает свою подругу из когтей убежавшей обезьяны, которая бросает в него бочками и молниями. Как она называлась?",
            "Doom","Starcraft",
            "Donkey Kong","Подземелья кремля",3
        )
        questionList.add(que7)
        return questionList
    }
}