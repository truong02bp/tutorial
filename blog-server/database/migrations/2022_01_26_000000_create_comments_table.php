<?php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
class CreateCommentsTable extends Migration {

    public function up()
    {
        Schema::create('comments', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('content');
            $table->string('avatar_url');
            $table->integer('post_id');
        });
    }
    public function down()
    {
        Schema::dropIfExists('comments');
    }
}
