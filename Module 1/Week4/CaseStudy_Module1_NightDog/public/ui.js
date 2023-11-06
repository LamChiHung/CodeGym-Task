export class UI {
    constructor(game) {
        this.game = game;
        this.fontSize = 30;
        this.fontFamily = "Helvetica"
        this.liveImage = document.getElementById("lives")

    }
    draw(context) {
        if (!this.game.gameOver) {
            context.font = this.fontSize + "px " + this.fontFamily;
            context.textAlign = "left";
            context.fillStyle = this.game.fontColor;
            //score
            context.fillText("Score: " + this.game.score, 20, 50);
            //energy
            context.fillText("Energy: ", 20, 150);
            context.fillRect(130, 130, this.game.energy, 25);
            context.strokeStyle = 'white';
            context.strokeRect(128, 127, 105, 31);


            //lives
            for (let i = 0; i < this.game.lives; i++) {
                context.drawImage(this.liveImage, 25 * i + 20, 95, 25, 25);
            }
            //timer
            context.font = this.fontSize * 0.8 + "px" + this.fontFamily;
            context.fillText("Time: " + (this.game.time * 0.001).toFixed(1), 20, 80);
        } else {
            if (this.game.score > 59) {
                //game over message
                // console.log(this.game.gameOver);
                context.textAlign = "center";
                context.font = this.fontSize * 2 + "px" + this.fontFamily;
                context.fillText("Boo-yah", this.game.width * 0.5, this.game.height * 0.5);
            } else {
                // console.log(this.game.gameOver);
                context.textAlign = "center";
                context.font = this.fontSize * 2 + "px" + this.fontFamily;
                context.fillText("Too Bad! You need 60 point", this.game.width * 0.5, this.game.height * 0.5);
            }

        }
    }
}