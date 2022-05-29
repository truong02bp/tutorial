<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Post extends Model
{
    protected $fillable = [
        'id',
        'title',
        'content',
        'image_url',
        'avatar_url',
        'created_by',
        'reactions',
        'created_date',
    ];
}
