<?php

namespace App\Http\Controllers;

use App\Models\Post;
use Illuminate\Http\Request;
use Illuminate\Routing\Controller;

class PostController extends Controller
{
    public function getAll(Request  $request) {
        return response(
            Post::all()
        );
    }
}
