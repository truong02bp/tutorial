<?php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
class CreatePostsTable extends Migration {

    public function up()
    {
        Schema::create('posts', function (Blueprint $table) {
            $table->id();
            $table->string('title');
            $table->string('content');
            $table->string('image_url')->nullable();
            $table->string('avatar_url');
            $table->string('created_by');
            $table->timestamp('created_date')->default(date('Y-m-d H:i:s'));
            $table->integer('reactions')->default(1);
        });
    }
    public function down()
    {
        Schema::dropIfExists('posts');
    }
}
