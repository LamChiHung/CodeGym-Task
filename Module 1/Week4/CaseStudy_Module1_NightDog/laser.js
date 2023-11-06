export class Laser {
    constructor(player, game) {
        this.player = player;
        this.status = false;
        this.game = game
        this.x = this.player.x + 90
        this.y = this.player.y + 30;
        this.width = this.game.width
        this.height = 10;
        this.color = `rgba(${Math.random() * 255},${Math.random() * 255},${Math.random() * 255},1)`
        this.sound = new Audio();
        this.sound.src = "./audio/playerLaser.wav"
    }
    update() {
        if (this.status == true) {
            this.sound.play();
        }
        this.x = this.player.x + 90;
        this.y = this.player.y + 30;
        this.color = `rgba(${Math.random() * 255},${Math.random() * 255},${Math.random() * 255},1)`
    }
    draw(context) {
        if (this.status == true) {
            context.fillStyle = this.color;
            context.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}

