const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
let paddleHeight = 10;
let paddleWidth = 75;
let paddleX = (canvas.width - paddleWidth) / 2;
let x = canvas.width / 2;
let y = canvas.height - 30;
let dx = 2;
let dy = -2;
canvas.width = 500;
canvas.height = 500;
let brickRowCount = 5;
let brickColumnCount = 3;
let brickWidth = 75;
let brickHeight = 20;
let brickPadding = 10;
let brickOffsetTop = 30;
let brickOffsetLeft = 30;
let lives = 3;
let score = 0;

class Ball {
  constructor(x, y, radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.dx = 3;
    this.dy = 3;
    this.color = "red";
  }
  draw() {
    ctx.beginPath();
    ctx.fillStyle = this.color;
    ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
    ctx.stroke();
    ctx.fill();
    ctx.closePath();
  }
  update() {
    this.draw();
    this.x += this.dx;
    this.y += this.dy;
  }
}
class Player {
  constructor(x, y, width, height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.dx = 0;
    this.dy = 0;
    this.color = "blue";
  }
  draw() {
    ctx.fillStyle = this.color;
    ctx.fillRect(this.x, this.y, this.width, this.height);
  }
  update() {
    this.draw();
    this.x += this.dx;
    this.y += this.dy;
  }
}

let ball = new Ball(canvas.width / 2, canvas.height / 2, 20);
let player = new Player(canvas.width / 2, canvas.height - 50, 200, 30);
let bricks = [];
for (let c = 0; c < brickColumnCount; c++) {
  bricks[c] = [];
  for (let r = 0; r < brickRowCount; r++) {
    bricks[c][r] = { x: 0, y: 0, status: 1 };
  }
}
console.log(bricks);

function collisionDetection() {
  for (let c = 0; c < brickColumnCount; c++) {
    for (let r = 0; r < brickRowCount; r++) {
      let b = bricks[c][r];
      if (b.status == 1) {
        if (
          ball.x > b.x &&
          ball.x < b.x + brickWidth &&
          ball.y > b.y &&
          ball.y < b.y + brickHeight
        ) {
          dy = -dy;
          b.status = 0;
          score++;
          if (score == brickRowCount * brickColumnCount) {
            alert("YOU WIN, CONGRATS!");
            document.location.reload();
          }
        }
      }
    }
  }
}
function drawBricks() {
  for (var c = 0; c < brickColumnCount; c++) {
    for (var r = 0; r < brickRowCount; r++) {
      if (bricks[c][r].status == 1) {
        var brickX = r * (brickWidth + brickPadding) + brickOffsetLeft;
        var brickY = c * (brickHeight + brickPadding) + brickOffsetTop;
        bricks[c][r].x = brickX;
        bricks[c][r].y = brickY;
        ctx.beginPath();
        ctx.fillRect(brickX, brickY, brickWidth, brickHeight);
        ctx.fillStyle = "#0095DD";
        ctx.fill();
        ctx.closePath();
      }
    }
  }
}
// function drawPaddle() {
//   ctx.beginPath();
//   ctx.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
//   ctx.fillStyle = "#0095DD";
//   ctx.fill();
//   ctx.closePath();
// }
const keys = {
  a: {
    pressed: false,
  },
  d: {
    pressed: false,
  },
};
function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  // drawBricks();
  // drawPaddle();
  // drawScore();
  // drawLives();


  if (x + dx > canvas.width - ball.radius || x + dx < ball.radius) {
    dx = -dx;
  }
  if (y + dy < ball.radius) {
    dy = -dy;
  } else if (y + dy > canvas.height - ball.radius) {
    if (x > paddleX && x < paddleX + paddleWidth) {
      dy = -dy;
    } else {
      lives--;
      if (!lives) {
        alert("GAME OVER");
        document.location.reload();
      } else {
        x = canvas.width / 2;
        y = canvas.height - 30;
        dx = 2;
        dy = -2;
        paddleX = (canvas.width - paddleWidth) / 2;
      }
    }
  }

  if (keys.d.pressed && paddleX < canvas.width - paddleWidth) {
    paddleX += 5;
  } else if (keys.a.pressed && paddleX > 0) {
    paddleX -= 5;
  }

  x += dx;
  y += dy;
  requestAnimationFrame(draw);
}

draw();
let newGame = false;
function animate() {
  let animateId = requestAnimationFrame(animate);
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ball.update();
  player.update();
  drawBricks();
  // drawPaddle();
  collisionDetection();
  document.getElementById("score").innerHTML = score;
  if (ball.x + ball.radius >= canvas.width || ball.x - ball.radius <= 0) {
    ball.dx = -ball.dx;
  }
  if (ball.y - ball.radius <= 0) {
    ball.dy = -ball.dy;
  }
  if (
    ball.x + ball.radius >= player.x &&
    ball.x - ball.radius <= player.x + player.width &&
    ball.y + ball.radius >= player.y
  ) {
    ball.dy = -(ball.dy + 1);
    // score++;
  }

  if (keys.a.pressed && player.x >= 0) {
    player.dx = -5;
  } else if (keys.d.pressed && player.x + player.width <= canvas.width) {
    player.dx = 5;
  } else {
    player.dx = 0;
  }

  if (ball.y + ball.radius > canvas.height) {
    cancelAnimationFrame(animateId);
    alert("GAME OVER SCORE " + score);
    newGame = confirm("New game?");
    if (newGame) {
      ball = new Ball(canvas.width / 2, canvas.height / 2, 20);
      player = new Player(canvas.width / 2, canvas.height - 50, 200, 30);
      score = 0;
      animate();
    }
  }
}

animate();

addEventListener("keydown", ({ key }) => {
  switch (key) {
    case "a":
      keys.a.pressed = true;
      break;
    case "d":
      keys.d.pressed = true;
      break;

    default:
      break;
  }
});
addEventListener("keyup", ({ key }) => {
  switch (key) {
    case "a":
      keys.a.pressed = false;

      break;

    case "d":
      keys.d.pressed = false;
      break;

    default:
      break;
  }
});
