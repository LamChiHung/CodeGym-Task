/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size, speed) {
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;
  this.speed = speed;

  this.getHeroElement = function () {
    return '<img width="' + this.size + '"' +
      ' height="' + this.size + '"' +
      ' src="' + this.image + '"' +
      ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
  }

  this.moveRight = function () {
    this.left += this.speed;
  }

  this.moveLeft = function () {
    this.left -= this.speed;
  }

  this.moveDown = function () {
    this.top += this.speed;
  }

  this.moveUp = function () {
    this.top -= this.speed;
  }

  this.move = function (evt) {
    let key = evt.keyCode;
    switch (key) {
      case 37:
        this.moveLeft();
        break;
      case 39:
        this.moveRight();
        break;
      case 38:
        this.moveUp();
        break;
      case 40:
        this.moveDown();
        break;
      default:
        break;
    }
  }

}

var hero = new Hero('zombie.png', 20, 30, 200, 100);

function move(evt) {
  hero.move(evt);
}
function start() {
  document.getElementById('game').innerHTML = hero.getHeroElement();
}
window.onload = start();
window.addEventListener("keydown", move);
window.addEventListener("keydown", start);
