package app.like

import app.currentUser
import io.javalin.Context

object LikeController {

    fun create(ctx: Context) {
        LikeDao.add(photoId = ctx.queryParam("photo-id")!!, ownerId = ctx.currentUser!!)
        ctx.status(201)
    }

    fun delete(ctx: Context) {
        LikeDao.delete(photoId = ctx.queryParam("photo-id")!!, ownerId = ctx.currentUser!!)
        ctx.status(204)
    }

}
