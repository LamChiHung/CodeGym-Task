import { Player } from "./player.js";
import { InputHandler } from "./input.js";
import { Background } from "./background.js";
import { FlyingEnemy, GroundEnemy, ClimbingEnemy } from "./enemy.js";
import { UI } from "./ui.js";

window.addEventListener("load", function () {
    let canvas = this.document.getElementById("canvas1");
    let ctx = canvas.getContext('2d');
    canvas.width = 1500;
    canvas.height = 500;


    class Game {
        constructor(width, height) {
            this.width = width;
            this.height = height;
            this.groundMargin = 80;
            this.speed = 0;
            this.maxSpeed = 6;
            this.background = new Background(this);
            this.player = new Player(this);
            this.input = new InputHandler(this);
            this.UI = new UI(this);
            this.enemies = [];
            this.particles = [];
            this.collisions = [];
            this.maxParticles = 50;
            this.enemyTimer = 0;
            this.enemyInterval = 1000;
            this.debug = false;
            this.score = 0;
            this.fontColor = "black";
            this.time = 0;
            this.maxTime = 60000;
            this.gameOver = false;
            this.lives = 5;
            this.energy = 100;
            this.player.currentState = this.player.states[0];
            this.player.currentState.enter();
            this.sound = new Audio();
            this.sound.src = "./audio/Running_through_worlds.wav"
            this.sound.volume = 0.5;
        }

        update(deltaTime) {
            this.time += deltaTime;
            if (this.time > this.maxTime) {
                this.gameOver = true;
            }
            this.background.update();
            this.player.update(this.input.key, deltaTime);

            //handler energy
            if (this.energy <= 100) {
                this.energy++;
            }
            if (this.player.currentState == this.player.states[4] || this.player.currentState == this.player.states[5]) {
                if (this.energy >= 0) {
                    this.energy -= 2;
                }
                if (this.energy == 0) {
                    this.player.setState(6, 0)
                }

            }
            if (this.player.laser.status == true) {
                if (this.energy >= 0) {
                    this.energy -= 10;
                }
                if (this.energy < 0) {
                    this.energy = 0;
                    this.player.laser.status = false;
                }
            }
            // handler Enemies
            if (this.enemyTimer > this.enemyInterval) {
                this.addEnemy();
                this.enemyTimer = 0;
            } else {
                this.enemyTimer += deltaTime;
            }
            this.enemies.forEach(enemy => {
                enemy.update(deltaTime);
                if (enemy.markedForDeletion) {
                    this.enemies.splice(this.enemies.indexOf(enemy), 1);
                }
            })
            //handle particles
            this.particles.forEach((particle, index) => {
                particle.update();
                if (particle.markedForDeletion) {
                    this.particles.splice(index, 1)
                }
            })
            if (this.particles.length > this.maxParticles) {
                this.particles.length = this.maxParticles;
            }
            //handle collision sprites
            this.collisions.forEach((collision, index) => {
                collision.update(deltaTime);
                if (collision.markedForDeletion) {
                    this.collisions.splice(index, 1);
                }
            })

        }
        draw(context) {
            this.background.draw(context);
            this.player.draw(context);
            this.enemies.forEach(enemy => {
                enemy.draw(context);
            })
            this.particles.forEach(particle => {
                particle.draw(context);
            })
            this.collisions.forEach(collision => {
                collision.draw(context);
            })
            this.UI.draw(context)
        }
        addEnemy() {
            if (this.speed > 0 && Math.random() < 0.5) {
                this.enemies.push(new GroundEnemy(this))
            } else if (this.speed > 0) {
                this.enemies.push(new ClimbingEnemy(this))
            }
            this.enemies.push(new FlyingEnemy(this))
        }
    }

    let game = new Game(canvas.width, canvas.height)
    let lastTime = 0;
    function animate(timeStamp) {
        let deltaTime = timeStamp - lastTime;
        lastTime = timeStamp;
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        game.draw(ctx);
        game.update(deltaTime);
        if (!game.gameOver) {
            requestAnimationFrame(animate);
        } else {
            game.UI.draw(ctx)
            game.sound.pause();
        }
    }
    function playSound() {
        game.sound.play()
    }
    animate(0);

    if (!game.gameOver) {
        document.addEventListener("keydown", playSound);
    }
})