export class InputHandler {
    constructor(game) {
        this.game = game;
        this.key = [];
        window.addEventListener("keydown", e => {
            if (
                (e.key == "ArrowDown" ||
                    e.key == "ArrowUp" ||
                    e.key == "ArrowLeft" ||
                    e.key == "ArrowRight" ||
                    e.key == " "
                )
                && this.key.indexOf(e.key) == -1) {
                this.key.push(e.key);
            } else if (e.key === "d") {
                // this.game.debug = !this.game.debug;
                if (this.game.energy > 90) {
                    this.game.player.laser.status = true;
                }
            }


        })
        window.addEventListener("keyup", e => {
            if (e.key == "ArrowDown" ||
                e.key == "ArrowUp" ||
                e.key == "ArrowLeft" ||
                e.key == "ArrowRight" ||
                e.key == " "
            ) {
                this.key.splice(this.key.indexOf(e.key), 1);
            }
            // console.log(e.key, this.key);
            else if (e.key === "d") {
                    this.game.player.laser.status = false;
            }

        })
    }
}