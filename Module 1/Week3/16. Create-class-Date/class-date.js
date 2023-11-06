let MyDate = function (day, month, year) {
    this.day = day;
    this.month = month;
    this.year = year;

    this.getDay = function () {
        return this.day;
    }
    this.getMonth = function () {
        return this.month;
    }
    this.getYear = function () {
        return this.year
    }

    this.setDay = function (day) {
        this.day = day;
    }
    this.setMonth = function (month) {
        this.month = month;
    }
    this.setYear = function (year) {
        this.year = year;
    }
        this.setDate = function (day, month, year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        this.dateString = function () {
            let dateString;
            dateString = this.day + "/" + this.month + "/" + this.year;
            return dateString;
        }
    }

let date = new MyDate(2, 10, 2007);

date.setDate(10,10,2019);

alert(date.dateString());

