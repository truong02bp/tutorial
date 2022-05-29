<?php

namespace App\Http\Controllers;

use App\Models\Comment;
use Illuminate\Http\Request;
use Illuminate\Routing\Controller;

class CommentController extends Controller
{

    public function getByPostId(Request $request) {
        $postId = $request['postId'];
        return Comment::query()->where('post_id',(int) $postId)->get();
    }
}
